package com.example.myapplication

open class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "online"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

}

class SmartTvDevice(deviceName: String, deviceCategory: String):
        SmartDevice(name = deviceName, category = deviceCategory){

    private var speakerVolume = 2
        set(value) {
            if (value in 1..100){
                field = value
            }
        }

    fun increaseSpeakerVolume(){
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume "
        )
    }
    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }

}

fun main(){
    val device = SmartDevice("Smart Light", "Lighting", 1)
    println(device.deviceStatus)

    val tvDevice = SmartTvDevice("dell tv","tv")
    tvDevice.turnOn()
}