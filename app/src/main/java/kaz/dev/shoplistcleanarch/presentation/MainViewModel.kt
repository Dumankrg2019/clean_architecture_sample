package kaz.dev.shoplistcleanarch.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kaz.dev.shoplistcleanarch.data.ShopListRepositoryImpl
import kaz.dev.shoplistcleanarch.domain.DeleteItemUseCase
import kaz.dev.shoplistcleanarch.domain.EditShopItemUseCase
import kaz.dev.shoplistcleanarch.domain.GetShopListUseCase
import kaz.dev.shoplistcleanarch.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}