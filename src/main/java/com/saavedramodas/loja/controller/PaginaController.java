package com.saavedramodas.loja.controller;

import com.saavedramodas.loja.dto.response.HomeResponseDTO;
import com.saavedramodas.loja.service.CanalRecebimentoService;
import com.saavedramodas.loja.service.HomeService;
import com.saavedramodas.loja.service.RelatorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PaginaController {

    private final HomeService homeService;
    private final CanalRecebimentoService canalRecebimentoService;
    private final RelatorioService relatorioService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/home-page")
    public String home(Model model) {

        HomeResponseDTO home =
                homeService.buscarDadosHome();

        model.addAttribute("home", home);

        return "home";
    }

    @GetMapping("/lancamentos-page")
    public String lancamentos(Model model){

        model.addAttribute(
                "canais",
                canalRecebimentoService.listarTodos()
        );

        return "lancamentos";
    }

    @GetMapping("/relatorios-page")
    public String relatorios(Model model) {

        model.addAttribute(
                "relatorio",
                relatorioService.buscarRelatorioMesAtual()
        );

        return "relatorios";
    }

    @GetMapping("/canais-page")
    public String canais() {
        return "canais";
    }

    @GetMapping("/historico-page")
    public String historico() {

        return "historico";

    }

    @GetMapping("/fiados-page")
    public String fiados() {
        return "fiados";
    }

}