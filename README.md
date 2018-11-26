# Elvish

## Syntax
### General
Every line ends in a `|` character

### Methods
Denoted by a `@` character <br>
Display text: `@show("TEXT")|` <br>
Get text: `@get("TEXT")|` <br>

### Variables
Not preceded by any non-alphabetic characters <br>
`example = "text"|`

### Conditionals
If: `?` <br>
Else if: `?` <br>
Else: `>` <br>

Each line in a conditional is preceded by a `/` character <br>

```
? example == "yes"
  / answer = "this"|
  / @show(answer)|
  / @get(what is your answer)|
?> example == "no"
  / answer = "that"|
>
  / @show("false")|
  / @get(what now?)|
```

## Team
| **Anthony Beckwith** | **Andrew Cohen** | **Sophia Hubscher** |
| :---: | :---:| :---: |
| <img src="https://avatars0.githubusercontent.com/u/28630201?s=460&v=4" width=200> | <img src="https://avatars2.githubusercontent.com/u/45371974?s=460&v=4" width=200> | <img src="https://avatars2.githubusercontent.com/u/33038334?s=460&v=4" width=200> |
| <a href="http://github.com/abeckwith" target="_blank">`github.com/abeckwith`</a> | <a href="http://github.com/Ep1cC0d3r" target="_blank">`github.com/Ep1cC0d3r`</a> | <a href="http://github.com/sophia-hubscher" target="_blank">`github.com/sophia-hubscher`</a> |
| **David Peppercorn** | **John Scheffel** | **Griffith Wood**|
| <img src="https://avatars2.githubusercontent.com/u/45371952?s=460&v=4" width=200> | <img src="https://avatars3.githubusercontent.com/u/42395117?s=96&v=4" width=200> | <img src="https://avatars2.githubusercontent.com/u/27563749?s=460&v=4" width=200> |
| <a href="http://github.com/dpeppercorn21" target="_blank">`github.com/dpeppercorn21`</a> | <a href="http://github.com/jscheffel821" target="_blank">`github.com/jscheffel821`</a> | <a href="http://github.com/gwood19" target="_blank">`github.com/gwood19`</a> |
