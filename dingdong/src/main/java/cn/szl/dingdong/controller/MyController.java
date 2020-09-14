package cn.szl.dingdong.controller;

import cn.szl.dingdong.pojo.*;
import cn.szl.dingdong.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MyController {

    @Autowired
    private GoodsServiceImp goodsServiceImp;

    @Autowired
    private OrderServiceImp orderServiceImp;

    @Autowired
    private CarServiceImp carServiceImp;

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private LocationServiceImp locationServiceImp;

    @RequestMapping({"/","/index.html","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/buy.html")
    public String buy(int Id, Model model){
        product product= goodsServiceImp.queryById(Id);
        model.addAttribute("product",product);
        return "buy";
    }


    @RequestMapping("/reset")
    public String reset(String username,String telephone,String code,String password1,String password2){
        User user = userServiceImp.queryByusername(username);
        if (user==null){
            return "find";
        }else if (!user.getTelephone().equals(telephone)){
            return "find";
        }else if (password1.equals("")){
            return "find";
        }else if (password1.equals(password2)){
            userServiceImp.update_username(username,password1);
            return "index";
        }else
            return "find";
    }

    @RequestMapping("/eamil-reset")
    public String emailreset(String email,String code,String password1,String password2){
        User user = userServiceImp.query_email(email);
        if (user==null){
            return "find";
        }else if (password1.equals("")){
            return "find";
        }else if(password1.equals(password2)){
            userServiceImp.update_email(email,password1);
            return "index";
        }else return "find";
    }


    @RequestMapping("/code")
    public String code(){
        return "find";
    }

    @RequestMapping("/fill_order")
    public String fill_order(String Id,HttpSession session,Model model,String number){

        session.setAttribute("id",Id);
        session.setAttribute("number",number);

        User loginUser = (User)session.getAttribute("loginUser");
        String username = loginUser.getUsername();

        List<Location> locations = locationServiceImp.queryByusername(username);
        product product = goodsServiceImp.queryById(Integer.parseInt(Id));
        model.addAttribute("locations",locations);
        model.addAttribute("product",product);
        model.addAttribute("number",Integer.parseInt(number));

        return "fill_order";
    }

    @RequestMapping("/add_location")
    public String add_location(Location location,HttpSession session){
        User loginUser = (User)session.getAttribute("loginUser");
        String username = loginUser.getUsername();

        location.setUsername(username);
        locationServiceImp.add_location(location);

        String id = (String)session.getAttribute("id");
        session.removeAttribute("id");

        String number = (String)session.getAttribute("number");
        session.removeAttribute("number");

        return "redirect:fill_order?Id="+id+"&number="+number;
    }

    @RequestMapping("/order")
    public String order(int Id,int number,String size,HttpSession session){
        product product = goodsServiceImp.queryById(Id);
        User loginUser = (User) session.getAttribute("loginUser");
        carServiceImp.add(loginUser.getUsername(),product.getName(),number,size,product.getPrice());
        return "redirect:buy.html?Id="+Id;
    }

    @RequestMapping("/delete")
    public String delete(int id,HttpSession session){
        carServiceImp.delete(id);

        User loginUser = (User)session.getAttribute("loginUser");
        String username = loginUser.getUsername();
        return "redirect:shop_car.html?username="+username;
    }

    @RequestMapping("/find.html")
    public String find(){
        return "find";
    }

    @GetMapping("/personal.html")
    public String personal(String username,Model model){
        List<order> orders = orderServiceImp.queryByusername(username);

        List<product> products = new ArrayList<>();
        Map<order,product> map = new HashMap<>();

        for (order order:orders){

            map.put(order,goodsServiceImp.queryById(order.getId()));
        }

        model.addAttribute("orders",orders);
        model.addAttribute("map",map);

        return "personal";
    }

    @RequestMapping("/product.html")
    public String product(Model model){
        model.addAttribute("products",goodsServiceImp.queryProductList());
        return "product";
    }

    @RequestMapping("/register.html")
    public String register(){
        return "register";
    }

    @RequestMapping("/toregister1")
    public String toregister1(String telephone, String password1, String password2){

        if (userServiceImp.queryBytelephone(telephone)) {
            if (!password1.equals("")) {
                if (password1.equals(password2)) {
                    if (userServiceImp.addUser(telephone, password1, "", telephone)) {
                        return "index";
                    } else {
                        return "register";
                    }
                } else {
                    return "register";
                }
            } else {
                return "register";
            }
        }else {
            return "register";
        }

    }

    @RequestMapping("/toregister2")
    public String toregister2(String email, String password1, String password2){

        if (userServiceImp.queryByemail(email)) {
            if (!password1.equals("")) {
                if (password1.equals(password2)) {
                    if (userServiceImp.addUser(email, password1, email, "")) {
                        return "index";
                    } else {
                        return "register";
                    }
                } else {
                    return "register";
                }
            } else {
                return "register";
            }
        }else {
            return "register";
        }

    }

    @RequestMapping("/toregister3")
    public String toregister3(String username, String password1, String password2){

        if (userServiceImp.queryByemail(username)) {
            if (!password1.equals("")) {
                if (password1.equals(password2)) {
                    if (userServiceImp.addUser(username, password1, "", "")) {
                        return "index";
                    } else {
                        return "register";
                    }
                } else {
                    return "register";
                }
            } else {
                return "register";
            }
        }else {
            return "register";
        }

    }


    @RequestMapping("/shop_car.html")
    public String shop_car(String username,Model model){

        List<car> cars = carServiceImp.queryByusername(username);

        Double price=0.00;
        for (car car:cars){
            price=price+car.getPrice()*car.getNumber();
        }

        model.addAttribute("cars",cars);
        model.addAttribute("price",price);

        return "shop_car";
    }

    @RequestMapping("/tologin")
    public String tologin(String username,String password,Model model){

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token); //执行登陆方法，如果没有异常则说明可以成功登陆返回首页

            //用于前端获得已登陆的用户
            Session session = subject.getSession();
            session.setAttribute("loginUser",subject.getPrincipal());

            return "redirect:index";
        }catch (UnknownAccountException e){ //用户名不存在异常
            model.addAttribute("msg","用户名错误");
            return "index";
        }catch (IncorrectCredentialsException e){ //密码不存在异常
            model.addAttribute("msg","密码错误");
            return "index";
        }


    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
}
