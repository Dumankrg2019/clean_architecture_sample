package kaz.dev.shoplistcleanarch.domain

data class ShopItem(
    val name:String,
    val count:Int,
    val enabled:Boolean,
    var id:Int = UNDEFINED
) {

    companion object {
        val UNDEFINED = -1
    }
}
