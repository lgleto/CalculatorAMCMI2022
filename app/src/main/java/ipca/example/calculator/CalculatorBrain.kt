package ipca.example.calculator

enum class Operator(op: Char){
    add('+'),
    divide('/'),
    subtract('-'),
    multiply('*')
}

class CalculatorBrain {

    var operand : Double? = null
    var operator : Operator? = null

    fun clear(){
        operand = null
        operator = null
    }

    fun doBinaryOperation(secondOperand:Double) : Boolean{
        operand?.let {
            when (operator) {
                Operator.add -> { operand = it + secondOperand }
                Operator.subtract -> { operand = it - secondOperand }
                Operator.multiply -> { operand = it * secondOperand }
                Operator.divide -> {
                    if (secondOperand == 0.0){
                        operand = null
                    }else{
                        operand = it / secondOperand
                    }
                }
            }
            return true
        }
        return false

    }

}
