//
//  CartView.swift
//  iosApp
//
//  Created by Do Duc Hieu on 27/04/2022.
//

import Foundation
import SwiftUI
import domain

struct CartView :View{
    @ObservedObject private var cartService = CartService()
    
    var body: some View {
        let cart = cartService.cart
        VStack {
            Text(domain.Extension().formatMoney(value: cart.getPrice()))
        }
    }
}
