package org.icode.msp.user.interceptor;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 拦截请求中分页的参数,并通过PageHelper设定分页信息
 **/

@Component
public class PageInterceptor implements HandlerInterceptor {

    //与前端分页描述需要保持一致
    public static final String PAGE_NUM = "pageNum";
    public static final String PAGE_SIZE= "pageSize";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String pns = request.getParameter(PAGE_NUM);
        String pss = request.getParameter(PAGE_SIZE);
        if(pns != null && !"".equals(pns) && pss != null &&  !"".equals(pss)) {
            Integer pageNum = Integer.valueOf(pns);
            Integer pageSize = Integer.valueOf(pss);
            PageHelper.startPage(pageNum,pageSize);
        }
        return true;
    }
}
