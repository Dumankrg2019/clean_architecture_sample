package kaz.dev.shoplistcleanarch.domain

class GetShopItemUseCase(private val shopItemRepository: ShopListRepository) {

    fun getShopItem(shopItemId:Int): ShopItem {
       return shopItemRepository.getShopItem(shopItemId)
    }
}