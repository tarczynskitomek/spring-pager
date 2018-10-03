package it.tarczynski.pager.service

import it.tarczynski.pager.model.Pager

interface PagerService {

    fun getPager(pageSize: Int, pageNumber: Int): Pager
}