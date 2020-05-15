# yekai
**redis lua 流量控制 秒杀 库存**

![Image text](https://raw.githubusercontent.com/shibazi/yekai/master/yekai-service/src/main/resources/6331589523764.jpg)

支持表达式语法，并且，或，大于、小于、等于。。。。

```
            &&           
         /      \         
      ==            ||     
    /   \        /      \    
  ICBC    BANK  ==        == 
              /    \     / \ 
            TRADE COED 201 TYPE

```
((TYPE==201)||(COED==TRADE))&&(BANK==ICBC)--> 5tps