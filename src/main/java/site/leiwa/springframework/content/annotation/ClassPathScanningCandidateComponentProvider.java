package site.leiwa.springframework.content.annotation;

import java.util.LinkedHashSet;
import java.util.Set;

import cn.hutool.core.util.ClassUtil;
import site.leiwa.springframework.beans.factory.config.BeanDefinition;
import site.leiwa.springframework.stereotype.Component;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/30
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
