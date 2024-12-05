<H>LeetCode IDEA plugin config

__Code FileName:__

```text
[$!{question.frontendQuestionId}]$!velocityTool.camelCaseName(${question.titleSlug})
```

__Code Template__

```text
package leetcode.editor.cn;

class $!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args) {
       Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug}).Solution();
       BaseTest.baseTest(solution, "");
    }
static
${question.code}
}
```


<h2>leetcode practice</h2>


_plugin: LeetCode with labuladong_

__Code FileName:__
```text
[${question.frontendQuestionId}]$!velocityTool.camelCaseName(${question.titleSlug})
```

__Code Template:__
```text
package leetcode.editor.cn;

class $!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args) {
        Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})
            .Solution();
        BaseTest.baseTest(solution, "");
    }
    static
${question.code}
}
```


