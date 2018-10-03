package it.tarczynski.pager.service

import it.tarczynski.pager.model.Pager
import org.springframework.stereotype.Service

@Service
class DefaultPagerService : PagerService {

    override fun getPager(pageSize: Int, pageNumber: Int): Pager {
        return Pager(256, pageSize, pageNumber)
    }
}