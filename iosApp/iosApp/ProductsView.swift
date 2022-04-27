//
//  ContentView.swift
//  kmmDemo
//
//  Created by Do Duc Hieu on 15/04/2022.
//

import SwiftUI
import domain

struct ProductsView: View {
    let greeting = Greeting()
    
    
    @ObservedObject private var productsObserver = ProductsService()
    @State var search = ""
    var body: some View {
        let products = productsObserver.products
        let columns = [
            GridItem(.flexible()),
            GridItem(.flexible())
        ]
        NavigationView {
            VStack{
                HStack{
                    TextField("Search products",text: $search).onChange(of: search, perform: {text in
                        productsObserver.search(text: text)
                    })
                    .frame(maxWidth:.infinity)
                    .padding(.horizontal)
                    .textFieldStyle(.roundedBorder)
                    NavigationLink(destination: CartView()) {
                        Image(systemName: "cart").padding(.trailing,20)
                    }
                }
                
                ScrollView {
                    LazyVGrid(columns: columns, spacing: 20) {
                        ForEach(products, id: \.self) { item in
                            VStack(alignment: .leading){
                                AsyncImage(
                                    url: URL.init(string: item.productInfo.imageUrl) ,
                                    content: { image in
                                        image.resizable()
                                            .aspectRatio(contentMode: .fit)
                                            .frame(maxWidth: 200, maxHeight: 200)
                                    },
                                    placeholder: {
                                        ProgressView()
                                    }
                                )
                                .padding(.horizontal)
                                .frame(width: 200, height: 200)
                                Text(item.productInfo.name)
                                    .lineLimit(2)
                                HStack(){
                                    Text(
                                        domain.Extension().formatMoney(value: item.prices[0].sellPrice)
                                    )
                                    .foregroundColor(.red)
                                    .font(.headline)
                                    Button {
                                        CartManager().addItem(product: item)
                                    } label: {
                                        Image(systemName: "cart.badge.plus")
                                    }
                                }
                                
                            }
                            .frame(alignment:.topLeading)
                            .frame(height:300)
                        }
                    }
                    .padding(.horizontal)
                }
                .frame(maxHeight: .infinity)
            }
            .frame(maxHeight:.infinity,alignment: .topLeading)
            .navigationBarHidden(true)
            //            .navigationTitle(Greeting().greeting())
        }
        
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ProductsView()
    }
}
