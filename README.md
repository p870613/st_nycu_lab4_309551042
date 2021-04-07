###### tags: `NYCU-Software-Testing-2021-lab`

[![CI/CD with Github Action](https://github.com/p870613/st_nycu_lab4_309551042/actions/workflows/action.yml/badge.svg?branch=master)](https://github.com/p870613/st_nycu_lab4_309551042/actions/workflows/action.yml)

NYCU-Software-Testing-2021-lab4
===

[TOC]
 
## 學號 
- student id : 309551042
- name: 林觀明
- 系級：資科工碩
- source: https://hackmd.io/l8sEncOYRy6Ox0I60zTk5Q?both
## github url
https://github.com/p870613/st_nycu_lab4_309551042
## part1
- Main.java
    - 單純input output 處理 + call `Game.java`的function
    ![](https://i.imgur.com/b8EfKG8.png)
- Game.java
    - `Check_input`
        - 檢查input是否符合規定
            ![](https://i.imgur.com/ANK0VLG.png)
    - `Result`
        - 就一個個把邏輯寫出來而已
        ![](https://i.imgur.com/PqCHVpe.png) 
## part2
- 先創3個`Stream<Arguments>` 分別可以導致`p1 win and p2 lose`, `p1 lose and p2 win`, `p1 and p2 draw` <br/>
![](https://i.imgur.com/V1Wc5BW.png)

- test case
    - p1 win and p2 lose <br/>
    ![](https://i.imgur.com/cuETYF5.png)

    - p1 lose and p2 win <br/>
    ![](https://i.imgur.com/Qy0n4GO.png)

    - p1 and p2 draw <br/>
    ![](https://i.imgur.com/HxwFmQZ.png)
    - input
        - valid input <br/>
        ![](https://i.imgur.com/9L7NZB4.png)
        - invalid input <br/>
        ![](https://i.imgur.com/TrzN4UY.png)

## part3
- Makefile
    ![](https://i.imgur.com/L46HYRQ.png)

    
- push and pull
    - 都使用branch `master`
    ![](https://i.imgur.com/AI1HKCV.png)
- job
    - compile
        - `runs-on: ubuntu-latest` : 表示跑在`ubuntu`上
        - steps
            - `actions/checkout@v2` 表示下載你的repo
            - `actions/setup-java@v1`: setup Java11
            - `chmod +x gradlew`: 給權限
            - `make compile`: compile
            
                
        ![](https://i.imgur.com/BdWnrpf.png)


    - test
        - `runs-on: ubuntu-latest` : 表示跑在`ubuntu`上
        - steps
            - `actions/checkout@v2` 表示下載你的repo
            - `chmod +x gradlew`: 給權限
            - `make test`: 進行測試
            - `actions/upload-artifact@v2` : 有report, 會把他upload, 他的名字叫作`testreport`, 路徑是`build/reports`
                ![](https://i.imgur.com/mVyaWSt.png)

        ![](https://i.imgur.com/IebBmA7.png)

    - assemble
        - `runs-on: ubuntu-latest` : 表示跑在`ubuntu`上
        - steps
            - `actions/checkout@v2` 表示下載你的repo
            - `chmod +x gradlew`: 給權限
            - `make assemble`: 建制jar檔
            - `actions/upload-artifact@v2` : 有jar檔, 會把他upload, 名字叫作`buildJar`, 路徑是`build/libs`
            ![](https://i.imgur.com/vMXxTY2.png)


        ![](https://i.imgur.com/qECqf5C.png)

## part4
- assemble
    - `runs-on: ubuntu-latest` : 表示跑在`ubuntu`
    - output
        - step做完之後 才會做 之後再`Release`會用 
        ![](https://i.imgur.com/DRjcwc7.png)

    - steps
        - `actions/checkout@v2` 表示下載你的repo
        - `chmod +x gradlew`: 給權限
        - `make assemble`: 建制jar檔
        - `id: get_jarname` : 要輸出jar檔名
            ![](https://i.imgur.com/2kbCtW6.png)
        - `id: get_artifact_jarname`: 要upload的檔名
        ![](https://i.imgur.com/qBxjH9P.png)

        - `actions/upload-artifact@v2` : 有jar檔, 會把他upload, 名字叫作`buildJar`, 路徑是`build/libs`
    ![](https://i.imgur.com/1lnaTVq.png)

- release
    - `runs-on: ubuntu-latest` : 表示跑在`ubuntu`
    - `id: getReleaseName` : 拿到tag的name
    - `actions/download-artifact@v2`: 把之前upload的東西載下來
        - `name: ${{needs.assemble.outputs.artifact_jar_name}}` 這是要抓檔名
    - `softprops/action-gh-release@v1`: 之後就release了
        - `steps.getReleaseName.outputs.RELEASE_NAME`: 抓tag的name
        - `needs.assemble.outputs.jar_name`:檔名
        - 就release了
            ![](https://i.imgur.com/9pG5Tai.png)

    ![](https://i.imgur.com/pOp3Avu.png)
