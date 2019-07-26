/**
 * Copyright (C), 2015-2019, XXXX有限公司
 * FileName: UmsAdminServiceImpl
 * Author:   YuSong
 * Date:     2019/5/25 18:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.raven.mall.tiny.service.impl;

import com.github.pagehelper.PageHelper;
import com.raven.mall.tiny.common.utils.JwtTokenUtil;
import com.raven.mall.tiny.dao.UmsAdminRoleRelationDao;
import com.raven.mall.tiny.mbg.mapper.UmsAdminLoginLogMapper;
import com.raven.mall.tiny.mbg.mapper.UmsAdminMapper;
import com.raven.mall.tiny.mbg.mapper.UmsAdminRoleRelationMapper;
import com.raven.mall.tiny.mbg.model.*;
import com.raven.mall.tiny.service.UmsAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <<UmsAdminService实现类>>
 *
 * @author Raven
 * @ Description: UmsAdminService实现类
 * @date 2019/5/25 18:00
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminServiceImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UmsAdminMapper adminMapper;

    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;

    @Autowired
    private UmsAdminRoleRelationDao adminRoleRelationDao;

    @Autowired
    private UmsAdminLoginLogMapper loginLogMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 根据用户名获取后台管理员
     *
     * @param username 用户名
     * @return
     */
    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    /**
     * 注册功能
     *
     * @param umsAdminParam 注册参数
     * @return 注册通知
     */
    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        //检查是否有相同用户名的用户
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        List<UmsAdmin> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 添加登录记录
     *
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UmsAdmin admin = getAdminByUsername(username);
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }

    /**
     * 根据用户名修改登录时间
     *
     * @param username 用户名
     */
    private void updateLoginTimeByUsername(String username) {
        UmsAdmin record = new UmsAdmin();
        record.setLoginTime(new Date());
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        adminMapper.updateByExampleSelective(record, example);
    }

    /**
     * 刷新token
     *
     * @param oldToken 旧的token
     * @return
     */
    @Override
    public String refreshToken(String oldToken) {
        String token = oldToken.substring(tokenHead.length());
        if (jwtTokenUtil.canRefresh(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

    /**
     * 根据用户id获取用户
     *
     * @param id 用户id
     * @return
     */
    @Override
    public UmsAdmin getItem(Long id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户名或昵称分页查询用户
     *
     * @param name 用户名
     * @param pageSize 每页数量
     * @param pageNum 页码
     * @return
     */
    @Override
    public List<UmsAdmin> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        UmsAdminExample example = new UmsAdminExample();
        UmsAdminExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)){
            criteria.andUsernameLike("%" + name + "%");
            example.or(example.createCriteria().andNickNameLike("%"+ name + "%"));
        }
        return adminMapper.selectByExample(example);

    }

    /**
     * 修改指定用户信息
     *
     * @param id 用户id
     * @param admin 管理账户
     * @return
     */
    @Override
    public int update(Long id, UmsAdmin admin) {
        admin.setId(id);
        //密码已经加密处理，需要单独修改
        admin.setPassword(null);
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    /**
     * 根据id删除指定用户
     *
     * @param id 用户id
     * @return
     */
    @Override
    public int delete(Long id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改用户角色关系
     *
     * @param adminId 管理员id
     * @param roleIds 角色关系
     * @return
     */
    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        UmsAdminRoleRelationExample adminRoleRelationExample = new UmsAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)){
            List<UmsAdminRoleRelation> list = new ArrayList<>();
            for (Long roleId  : roleIds) {
                UmsAdminRoleRelation roleRelation = new UmsAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationDao.insertList(list);
        }
        return count;
    }

    /**
     * 修改用户的+-权限
     *
     * @param adminId 管理员id
     * @return
     */
    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    @Override
    public int updatePermission(Long adminId, List<Long> permissionIds) {
        return 0;
    }

    /**
     * 获取用户所有权限(包括 角色权限和+-权限)
     *
     * @param adminId 管理员id
     * @return
     */
    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }
}