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
        VStack {
            ScrollView {
                LazyVStack(alignment: .leading) {
                    ForEach(items,id : \.sku){ item in
                        HStack(alignment:.top){
                            AsyncImage(
                                url: URL.init(string: item.image) ,
                                content: { image in
                                    image.resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(maxWidth: 100, maxHeight: 100)
                                },
                                placeholder: {
                                    ProgressView()
                                }
                            )
                            .padding(.horizontal)
                            .frame(width: 100, height: 100)
                            .border(Color.gray, width: 0.5)
                            VStack(alignment:HorizontalAlignment.leading){
                                Text(item.name)
                                Spacer()
                                HStack{
                                    Text(
                                        domain.Extension().formatMoney(value: item.price)
                                    )
                                    .foregroundColor(.red)
                                    .font(.headline)
                                    
                                    Spacer()
                                    Text("x\(item.quantity)")
                                }
                                
                            }
                            Spacer()
                        }
                        .padding(.bottom)
                        .overlay(
                            Rectangle()
                                .frame(height: 0.5)
                                .foregroundColor(.gray),
                            alignment: .bottom
                        )
                        
                    }
                }
                .padding(.horizontal)
            }
            .frame(maxHeight: .infinity)
            HStack(){
                Spacer()
                Text("Tổng thanh toán: ")
                Text(domain.Extension().formatMoney(value: cart.getPrice()))
                    .font(.system(size: 24,weight: Font.Weight.bold))
                    .foregroundColor(.red)
                
            }
        }.frame(maxWidth: .infinity, maxHeight:.infinity, alignment: .leading)
    }
}

struct CartView_Previews: PreviewProvider {
    static var previews: some View {
        CartView()
    }
}

