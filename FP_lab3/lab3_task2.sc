
( define (f1 a b n f   ); зовнішня функція
  (define (f2 t h b f acc)
      (if (>=  t b)
          acc
      (f2 (+ t h) h b f (+ acc (f t)))      
          )
      )
  
  
  (*(/(- b a) n) (f2 a (/ (- b a)n) b f 0 ))
    )
(display "1 спосіб: ")
(display( f1 0 3.14 500 ( lambda ( x )( cos (- x (sin x ) ) ))    )); виклик функції
(newline);(cos (- x (sin x ) ) )

( define (f1 a b n f   ); зовнішня функція
  (define (f2 t h b f acc)
      (if (>=  t b)
          acc
      (f2 (+ t h) h b f (+ acc (f t)))      
          )
      )
  
  ( let ((h0 (/(- b a) n) ))
  (* h0  (+(f2 (+ a h0) h0 (- b h0) f 0 ) (/ (+ (f a) (f b))  2 )  ))
    )
)
(display "2 спосіб: ")
(display( f1 0 3.14 500 ( lambda ( x )( cos (- x (sin x ) ) ))    )); виклик функції
(newline);(cos (- x (sin x ) ) )
