package com.ominext.restapi.repository

import com.ominext.restapi.model.Medication

class MedicationRepository {
    var medications = ArrayList<Medication>()

    fun save(medication: Medication) {
        medications.add(medication)
    }

    fun get(): ArrayList<Medication> {
        return medications
    }

    fun findById(id: Int): List<Medication> {
        return medications.filter { it.id == id }
    }

    fun update(medication: Medication) {
        medications.filter { it.id == medication.id }.first().apply {
            name = medication.name
            takenDateTime = medication.takenDateTime
        }
    }

    fun deleteById(id: Int): String {
        medications.removeIf { it.id == id }
        return "delete successful"
    }
}