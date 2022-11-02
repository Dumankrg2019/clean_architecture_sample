package kaz.dev.shoplistcleanarch.domain

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem:ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}