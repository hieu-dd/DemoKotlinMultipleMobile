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
    @State private var rememberMe = false
    
    var body : some View {
        VStack (){
            VStack{}.frame(height:80)
            Text(Greeting().greeting())
                .font(.system(size: 40,weight: Font.Weight.bold))
            
            VStack(alignment:.leading,spacing:15){
                TextField("Username",text: $userName)
                    .textFieldStyle(.roundedBorder)
                
                TextField("Password",text: $password)
                    .textFieldStyle(.roundedBorder)
                Toggle(isOn: $rememberMe) {
                    Text("Remember me")
                }
                .toggleStyle(CheckboxStyle())
                Button("Sign In", action: {
                    if(authManager
                        .login(userName: userName, password: password,rememberMe: rememberMe)){
                        willMoveToNextScreen = true
                    }
                })
            }
            .padding(50)
            .frame(height: 300, alignment: .trailing)
            VStack{}.frame(height:80)
        }
        .navigate(to: ProductsView(), when: $willMoveToNextScreen)
    }
}

struct CheckboxStyle: ToggleStyle {
    
    func makeBody(configuration: Self.Configuration) -> some View {
        
        return HStack {
            Image(systemName: configuration.isOn ? "checkmark.square" : "square")
                .resizable()
                .frame(width: 24, height: 24)
                .foregroundColor(configuration.isOn ? .blue : .gray)
                .font(.system(size: 20, weight: .regular, design: .default))
            configuration.label
        }
        .onTapGesture { configuration.isOn.toggle() }
        
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}

