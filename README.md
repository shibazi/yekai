# yekai
redis lua 流量控制 秒杀 库存


支持表达式语法，并且，或，大于、小于、等于。。。。

            &&           
         /      \         
      ==            ||     
    /   \        /      \    
  ICBC    BANK  ==        == 
              /    \     / \ 
            TRADE COED 201 TYPE

((TYPE==201)||(COED==TRADE))&&(BANK==ICBC)--> 5tps