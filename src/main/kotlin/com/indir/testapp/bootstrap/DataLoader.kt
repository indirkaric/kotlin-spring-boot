package com.indir.testapp.bootstrap

import com.indir.testapp.entity.User
import com.indir.testapp.repository.UserRepository
import org.hibernate.annotations.common.util.impl.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


@Component
class DataLoader:CommandLineRunner {

    @Autowired
    lateinit var userRepository: UserRepository
    var logger:LoggerFactory = LoggerFactory()

    override fun run(vararg args: String?) {
        if (userRepository.count() <= 0) {
            var user = User(firstName = "John", lastName = "Doe", username = "John.Doe2")
            userRepository.save(user)
            logger.run { println("User saved ...") }
        }
    }
}