package it.tarczynski.pager.controller

import it.tarczynski.pager.model.Link
import it.tarczynski.pager.service.PagerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pager")
class PagerController(val pagerService: PagerService) {

    @GetMapping
    fun getPager(@RequestParam("ps", defaultValue = "10") pageSize: Int,
                 @RequestParam("pn") currentPage: Int): Array<Link> {
        return pagerService.getPager(pageSize, currentPage).pagesToPrint
    }

}