package com.example.sbt

import org.springframework.boot.web.server.WebServer
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import org.springframework.web.servlet.DispatcherServlet


class WebApplicationContext : AnnotationConfigWebApplicationContext() {
    @Suppress("ACCIDENTAL_OVERRIDE")
    override fun setClassLoader(classLoader: ClassLoader) {
        this.classLoader = classLoader
    }

    override fun onRefresh() {
        super.onRefresh()
        val serverFactory: ServletWebServerFactory = this.getBean(ServletWebServerFactory::class.java)
        val dispatcherServlet = this.getBean(DispatcherServlet::class.java)

        val webServer: WebServer = serverFactory.getWebServer(
            ServletContextInitializer { servletContext ->
                servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                    .addMapping("/*") // 모든 요청을 처리하기 위해 와일드 카드로 변경 한다.
            })
        webServer.start()
    }
}



inline fun <reified T : Any> myRunApplication(vararg args: String) {
    val applicationContext = WebApplicationContext()
    applicationContext.apply {
        register(T::class.java)
        refresh()
    }
}