//
//  LoginView.swift
//  iosApp
//
//  Created by Do Duc Hieu on 27/04/2022.
//

import Foundation
import SwiftUI


struct LoginView : View {
    
    @State private var willMoveToNextScreen = false
    @State private var userName = ""
    @State private var password = ""
    
    
    var body : some View {
        
        VStack {
            TextField("Search products",text: $userName)
            TextField("Search products",text: $password)
            Button("Sign In", action: {
                if(!userName.isEmpty && !password.isEmpty){
                    willMoveToNextScreen = true
                }
            })
        }
        .navigate(to: ContentView(), when: $willMoveToNextScreen)
    }
}

extension View {
    func navigate<NewView: View>(to view: NewView, when binding: Binding<Bool>) -> some View {
        NavigationView {
            ZStack {
                self
                    .navigationBarTitle("")
                    .navigationBarHidden(true)
                
                NavigationLink(
                    destination: view
                        .navigationBarTitle("")
                        .navigationBarHidden(true),
                    isActive: binding
                ) {
                    EmptyView()
                }
            }
        }
        .navigationViewStyle(.stack)
    }
}
