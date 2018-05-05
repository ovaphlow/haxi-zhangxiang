package hengda.haxi.zhangxiang

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
class ZhangxiangApplication

fun main(args: Array<String>) {
    // runApplication<ZhangxiangApplication>(*args)
    SpringApplication.run(ZhangxiangApplication::class.java, *args)
}
