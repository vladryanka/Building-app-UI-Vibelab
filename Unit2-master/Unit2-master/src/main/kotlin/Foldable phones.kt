open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(isScreenLightOn: Boolean = false, var isFolded: Boolean = false) : Phone(isScreenLightOn) {

    override fun switchOn() {
        if (!isFolded) {
            isScreenLightOn = true
        }
    }

    fun fold() {
        isFolded = true
        if (isScreenLightOn) {
            switchOff()
        }
    }

    fun unfold() {
        isFolded = false
    }
}

fun main() {
    val foldablePhone = FoldablePhone()

    foldablePhone.checkPhoneScreenLight()

    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()

    foldablePhone.fold()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()

    foldablePhone.unfold()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
}