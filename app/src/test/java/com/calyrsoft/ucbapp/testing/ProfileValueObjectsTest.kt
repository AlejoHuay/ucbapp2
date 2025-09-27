package com.calyrsoft.ucbapp.testing

import com.calyrsoft.ucbapp.features.profile.domain.model.ProfileEmail
import com.calyrsoft.ucbapp.features.profile.domain.model.ProfileName
import com.calyrsoft.ucbapp.features.profile.domain.model.ProfilePhone
import com.calyrsoft.ucbapp.features.profile.domain.model.ProfileSummary
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.fail

class ProfileValueObjectsTest {

    // -------- ProfileName --------
    @Test
    fun ProfileNameaceptanombresquenoestenvacios() {
        val vo = ProfileName("Homero")
        assertEquals("Homero", vo.value)
    }

    @Test
    fun ProfileNamefallacunadoestavacio() {
        try {
            ProfileName("")
            fail("Debió lanzar IllegalArgumentException")
        } catch (e: IllegalArgumentException) {
            assertTrue(e.message!!.contains("no puede estar vacío"))
        }
    }

    // -------- ProfileEmail --------
    @Test
    fun ProfileEmailaceptaformatovalido() {
        val vo = ProfileEmail("homero.simpson@springfieldmail.com")
        assertEquals("homero.simpson@springfieldmail.com", vo.value)
    }

    @Test
    fun ProfileEmailiformatoesinvalido() {
        try {
            ProfileEmail("correo-invalido")
            fail("Debió lanzar IllegalArgumentException")
        } catch (e: IllegalArgumentException) {
            assertTrue(e.message!!.contains("válido"))
        }
    }

    // -------- ProfilePhone --------
    @Test
    fun ProfilePhoneaceptaformatosimple() {
        val vo = ProfilePhone("+19395557422")
        assertEquals("+19395557422", vo.value)
    }

    @Test
    fun ProfilePhoneiformatoesinvalido() {
        try {
            ProfilePhone("abc-123")
            fail("Debió lanzar IllegalArgumentException")
        } catch (e: IllegalArgumentException) {
            assertTrue(e.message!!.contains("no es válido"))
        }
    }

    // -------- ProfileSummary --------
    @Test
    fun ProfileSummaryaceptatextocualquiera() {
        val vo = ProfileSummary("Inspector de la planta nuclear")
        assertEquals("Inspector de la planta nuclear", vo.value)
    }
}