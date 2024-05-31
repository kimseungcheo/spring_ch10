package daelim.spring_ch10.controller;

import daelim.spring_ch10.LoginCommand;
import daelim.spring_ch10.WrongPasswordException;
import daelim.spring_ch10.AuthInfo;
import daelim.spring_ch10.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private AuthService authService;
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String form(LoginCommand loginCommand) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String submit(LoginCommand loginCommand, Errors errors) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if(errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
            AuthInfo authInfo = authService.authenicate(loginCommand.getEmail(), loginCommand.getPassword());
            //TODO 세션에 authInfo 저장
            return "login/loginSuccess";
        }catch (WrongPasswordException ex) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/main";
    }
}
