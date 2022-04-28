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
    @Published var items :[CartItem]
    let cartManager = CartManager()
    init(){
        self.cart = Cart(items: [])
        self.items = []
        cartManager.observerCart { c in
            self.cart = c
            self.items = c.items as! [CartItem]
        }
    }
    
    func addItem(p:Product)  {
        cartManager.addItem(product: p)
    }
}

