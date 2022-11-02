package kaz.dev.shoplistcleanarch.domain

class EditShopItemUseCase(private val shopItemRepository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem){
        shopItemRepository.editShopItem(shopItem)
    }
}