import React from 'react';
import { render, screen } from '@testing-library/react';
import NoPage404 from './NoPage404';

test('renders learn react link', () => {
  render(<NoPage404 />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});