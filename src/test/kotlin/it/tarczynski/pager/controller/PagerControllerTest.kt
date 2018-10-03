package it.tarczynski.pager.controller

import it.tarczynski.pager.service.DefaultPagerService
import it.tarczynski.pager.service.PagerService
import org.hamcrest.Matchers.*
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class PagerControllerTest {

    private var pagerService: PagerService = DefaultPagerService()

    private var pagerController: PagerController = PagerController(pagerService)
    private var mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(pagerController)
            .build()

    @Test
    fun shouldReturnJsonWithSimplePager() {
        mockMvc.perform(get("/pager").param("pn", "1"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize<Int>(5)))
                .andExpect(jsonPath("$[0].label", `is`("1")))
                .andExpect(jsonPath("$[0].url", isEmptyOrNullString()))

        mockMvc.perform(get("/pager").param("ps", "10").param("pn", "2"))
                .andExpect(status().isOk)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize<Int>(3)))
                .andExpect(jsonPath("$[0].label", `is`("<")))
                .andExpect(jsonPath("$[0].url", `is`(1)))
                .andExpect(jsonPath("$[1].label", `is`("1")))
                .andExpect(jsonPath("$[1].url", `is`(1)))
                .andExpect(jsonPath("$[2].label", `is`("2")))
                .andExpect(jsonPath("$[2].url", isEmptyOrNullString()))
    }
}