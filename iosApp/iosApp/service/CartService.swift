//
//  CartService.swift
//  iosApp
//
//  Created by Do Duc Hieu on 27/04/2022.
//

import Foundation
import domain
class CartService : ObservableObject{
    @Published var cart: Cart
    let cartManager = CartManager()
    init(){
        self.cart = Cart(items: [])
        cartManager.observerCart { c in
            self.cart = c
        }
    }
    
    func addItem(p:Product)  {
        cartManager.addItem(product: p)
    }
}

