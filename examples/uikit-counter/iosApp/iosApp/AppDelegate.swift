//
//  AppDelegate.swift
//  iosApp
//
//  Created by zhanghuabin on 2024/10/28.
//  Copyright © 2024 orgName. All rights reserved.
//

import UIKit

@main
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        window?.rootViewController = ViewController() // 设置根视图控制器
        window?.makeKeyAndVisible()
        return true
    }
}
