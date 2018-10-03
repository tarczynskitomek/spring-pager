package it.tarczynski.pager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PagerApplication

fun main(args: Array<String>) {
    runApplication<PagerApplication>(*args)
}
