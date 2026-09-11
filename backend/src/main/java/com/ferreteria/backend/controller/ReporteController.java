package com.ferreteria.backend.controller;

import com.ferreteria.backend.dto.RankingItemDTO;
import com.ferreteria.backend.dto.ReporteResumenDTO;
import com.ferreteria.backend.service.ReporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {
    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/resumen")
    public ResponseEntity<ReporteResumenDTO> resumen() {
        return ResponseEntity.ok(reporteService.generarResumen());
    }

    @GetMapping("/productos-por-categoria")
    public ResponseEntity<List<RankingItemDTO>> productosPorCategoria() {
        return ResponseEntity.ok(reporteService.productosPorCategoria());
    }
}
