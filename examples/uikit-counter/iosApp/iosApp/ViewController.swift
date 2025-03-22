//
//  ViewController.swift
//  iosApp
//
//  Created by zhanghuabin on 2024/10/28.
//  Copyright © 2024 orgName. All rights reserved.
//


import UIKit
import Shared

class ViewController: UIViewController {

    override func viewDidLoad() {
        let target = Greeting().loadView(context: 1) as! UIView
        target.backgroundColor = .white
        self.view.addSubview(target)
        NSLayoutConstraint.activate([
            target.topAnchor.constraint(equalTo: self.view.topAnchor),
            target.bottomAnchor.constraint(equalTo: self.view.bottomAnchor),
            target.leadingAnchor.constraint(equalTo: self.view.leadingAnchor),
            target.trailingAnchor.constraint(equalTo: self.view.trailingAnchor),
        ])
    }
}
