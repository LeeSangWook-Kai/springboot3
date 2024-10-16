package org.k8go4go.controller;

import lombok.RequiredArgsConstructor;
import org.k8go4go.dto.view.AddUserRequest;
import org.k8go4go.serice.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.save(request);

        return "redirect:/login";
    }
}
