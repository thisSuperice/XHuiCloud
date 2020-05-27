package com.zsinda.fdp.service.impl;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.zsinda.fdp.entity.SysDept;
import com.zsinda.fdp.mapper.SysDeptMapper;
import com.zsinda.fdp.service.SysDeptService;
import com.zsinda.fdp.vo.DeptVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public List<Integer> getAllDeptIds() {
        return list(Wrappers.emptyWrapper()).stream().map(SysDept::getDeptId).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveDept(SysDept sysDept) {
        return save(sysDept);
    }

    @Override
    public Boolean deleteDept(Integer id) {
        return null;
    }

    @Override
    public Boolean updateDept(SysDept sysDept) {
        return null;
    }

    @Override
    public List<List<Integer>> getDeptTree(List<DeptVo> deptVos) {
        List<SysDept> sysDepts = list(Wrappers.emptyWrapper());
        List<List<Integer>> depts = Lists.newArrayList();
        for (DeptVo deptVo : deptVos) {
            List<Integer> oneDepts = Lists.newArrayList();
            completeDepts(sysDepts, deptVo.getDeptId(), oneDepts);
            Collections.sort(oneDepts);
            depts.add(oneDepts);
        }
        return depts;
    }

    /**
     * 补全完整的部门id
     * @param sysDepts
     * @param deptId
     * @param oneDepts
     */
    private void completeDepts(List<SysDept> sysDepts, Integer deptId, List<Integer> oneDepts) {
        for (SysDept sysDept : sysDepts) {
            if (deptId == sysDept.getDeptId()) {
                oneDepts.add(deptId);
                if (sysDept.getParentId() != 0 ){
                    completeDepts(sysDepts, sysDept.getParentId(), oneDepts);
                }
            }
        }
    }

}
