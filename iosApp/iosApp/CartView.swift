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
        let items = cartService.items
        let columns = [
            GridItem(.flexible()),
        ]
        NavigationView {
            VStack {
                Text("Gio hang cua toi")
                ScrollView {
                    LazyVGrid(columns: columns, spacing: 20) {
                        ForEach(items,id : \.sku){ item in
                            Text(item.sku)
                            
                        }
                    }
                    .padding(.horizontal)
                }
                .frame(maxHeight: .infinity)
                Text(domain.Extension().formatMoney(value: cart.getPrice()))
            }.frame(maxWidth: .infinity, maxHeight:.infinity, alignment: .leading)
                .navigationBarTitle(Text("WeSplit"))     // << here !!
        }
        
        
    }
}

struct CartView_Previews: PreviewProvider {
    static var previews: some View {
        CartView()
    }
}

