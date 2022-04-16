//
//  ProductsService.swift
//  kmmDemo
//
//  Created by Do Duc Hieu on 15/04/2022.
//

import Foundation
import domain
class ProductsService : ObservableObject{
    @Published var products: [Product]
    let productsManager = ProductsManager()
    init(){
        self.products = []
        productsManager.observerProducts(onSuccess: { p in
            self.products = p
        })
    }
    
    func search(text:String)  {
        productsManager.search(text: text)
    }
}

