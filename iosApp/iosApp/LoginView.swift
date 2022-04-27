//
//  LoginView.swift
//  iosApp
//
//  Created by Do Duc Hieu on 27/04/2022.
//

import Foundation
import SwiftUI
import domain

struct LoginView : View {
    private var authManager = AuthManager(context : NSObject.init())
    @State private var willMoveToNextScreen = AuthManager(context : NSObject.init()).isLogin()
    @State private var userName = ""
    @State private var password = ""
    
    
    var body : some View {
        
        VStack {
            TextField("Search products",text: $userName)
            TextField("Search products",text: $password)
            Button("Sign In", action: {
                if(authManager
                    .login(userName: userName, password: password)){
                    willMoveToNextScreen = true
                }
            })
        }
        .navigate(to: ProductsView(), when: $willMoveToNextScreen)
    }
}

