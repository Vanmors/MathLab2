Численное решение нелинейных уравнений и систем
Цель работы: изучить численные методы решения нелинейных уравнений и их систем, найти корни заданного нелинейного уравнения/системы нелинейных уравнений, выполнить программную реализацию методов.
№ варианта определяется как номер в списке группы согласно ИСУ. 
Лабораторная работа состоит из двух частей: вычислительной и программной.

Для нелинейных уравнений:
1. Все численные методы (см. табл. 8) должны быть реализованы в виде отдельных подпрограмм/методов/классов.
2. Пользователь выбирает уравнение, корень/корни которого требуется вычислить (3-5 функций, в том числе и трансцендентные), из тех, которые предлагает 
программа.
3. Предусмотреть ввод исходных данных (границы интервала/начальное приближение к корню и погрешность вычисления) из файла или с клавиатуры по выбору конечного пользователя. 
4. Выполнить верификацию исходных данных. Необходимо анализировать наличие корня на введенном интервале. Если на интервале несколько корней или 
они отсутствуют – выдавать соответствующее сообщение. Программа должна 
реагировать на некорректные введенные данные.
5. Для методов, требующих начальное приближение к корню (методы Ньютона,
секущих, хорд с фиксированным концом), выбор начального приближения (а 
или b) вычислять в программе.
6. Для метода простой итерации проверять достаточное условие сходимости метода на введенном интервале. 
7. Предусмотреть вывод результатов (найденный корень уравнения, значение 
функции в корне, число итераций) в файл или на экран по выбору конечного 
пользователя.
8. Организовать вывод графика функции, график должен полностью отображать 
весь исследуемый интервал (с запасом).

Для систем нелинейных уравнений:
1. Пользователь выбирает предлагаемые программой системы двух нелинейных 
уравнений (2-3 системы).
2. Организовать вывод графика функций.
3. Начальные приближения ввести с клавиатуры.
4. Для метода простой итерации проверить достаточное условие сходимости.
5. Организовать вывод вектора неизвестных: 𝑥1, 𝑥2.
6. Организовать вывод количества итераций, за которое было найдено решение.
7. Организовать вывод вектора погрешностей: |𝑥𝑖(𝑘) − 𝑥𝑖(𝑘−1)|
8. Проверить правильность решения системы нелинейных уравнений.