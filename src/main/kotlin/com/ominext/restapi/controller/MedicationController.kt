package com.ominext.restapi.controller

import com.ominext.restapi.model.Medication
import com.ominext.restapi.repository.MedicationRepository
import org.springframework.web.bind.annotation.*

@RestController
class MedicationController {

    var repository: MedicationRepository = MedicationRepository()

    @RequestMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    @RequestMapping("/save")
    fun save(): String {
        repository.save(Medication().apply {
            id = 1
            name = "A"
            takenDateTime = "12-22-2220"
        })
        repository.save(Medication().apply {
            id = 2
            name = "B"
            takenDateTime = "12-22-2220"
        })
        repository.save(Medication().apply {
            id = 3
            name = "C"
            takenDateTime = "12-22-2220"
        })
        return "Save successful"
    }

    @RequestMapping("/findAll")
    fun findAll() = repository.get()

    @RequestMapping("/findById/{id}")
    fun findById(@PathVariable id: Int) = repository.findById(id)

    @RequestMapping("/update")
    fun update(@RequestParam id: Int, @RequestParam name: String, @RequestParam takenDateTime: String): String {
        repository.update(Medication().apply {
            this.id = id
            this.name = name
            this.takenDateTime = takenDateTime
        })
        return "update successful"
    }

    @RequestMapping("/delete/{id}")
    fun delete(@PathVariable id: Int) = repository.deleteById(id)
}