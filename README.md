# 实现二叉排序树的增和删
    重点讨论删除
    当要删除节点 无子节点时,直接删除
    当要删除节点 有一点左或右子节点时,
        删除后直接赋值字节点
    当要删除节点  左右节点都存在,则根据
        子根节点左子树值,都小于根节点值,
        右子树都大于根节点值!
        找到左子树最大值或  右子树最小值