USE db_catalogo;

INSERT INTO categorias (nombre) VALUES
  ('Programación'),
  ('Ciencia Ficción'),
  ('Literatura Latinoamericana');

INSERT INTO libros (titulo, autor, stock, categoria_id) VALUES
  ('Hacking: The Art of Exploitation', 'Jon Erickson', 3, (SELECT id FROM categorias WHERE nombre = 'Programación')),
  ('The Pragmatic Programmer', 'David Thomas y Andrew Hunt', 4, (SELECT id FROM categorias WHERE nombre = 'Programación')),
  ('Código completo', 'Steve McConnell', 2, (SELECT id FROM categorias WHERE nombre = 'Programación')),
  ('Dune', 'Frank Herbert', 6, (SELECT id FROM categorias WHERE nombre = 'Ciencia Ficción')),
  ('Fundación', 'Isaac Asimov', 4, (SELECT id FROM categorias WHERE nombre = 'Ciencia Ficción')),
  ('Fahrenheit 451', 'Ray Bradbury', 5, (SELECT id FROM categorias WHERE nombre = 'Ciencia Ficción')),
  ('María', 'Jorge Isaacs', 3, (SELECT id FROM categorias WHERE nombre = 'Literatura Latinoamericana')),
  ('Como agua para chocolate', 'Laura Esquivel', 4, (SELECT id FROM categorias WHERE nombre = 'Literatura Latinoamericana')),
  ('El amor en los tiempos del cólera', 'Gabriel García Márquez', 5, (SELECT id FROM categorias WHERE nombre = 'Literatura Latinoamericana'));