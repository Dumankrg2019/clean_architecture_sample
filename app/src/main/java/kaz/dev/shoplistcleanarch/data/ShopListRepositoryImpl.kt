package kaz.dev.shoplistcleanarch.data

import kaz.dev.shoplistcleanarch.domain.ShopItem
import kaz.dev.shoplistcleanarch.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl:ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for(i in 0 until 10) {
            val item  = ShopItem("Name $i", i, true)
            addShopItem(item)
        }
    }
    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItem: Int): ShopItem {
        return shopList.find {
            it.id == shopItem }
            ?: throw RuntimeException("Element with id $shopItem not found")
    }

    override fun getShopList(): List<ShopItem> {
       return shopList.toList()
    }

}