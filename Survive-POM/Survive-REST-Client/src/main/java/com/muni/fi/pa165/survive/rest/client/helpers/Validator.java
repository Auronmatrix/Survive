/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muni.fi.pa165.survive.rest.client.helpers;

import org.apache.commons.cli.CommandLine;

/**
 *
 * @author Auron
 */
public class Validator {

    /**
     * Validate a command line.
     *
     * @param line command line to validate
     * @return true if command line is valid, false otherwise
     */
    public static boolean validate(CommandLine line) {
      
        // WEAPON
        if (line.hasOption("w")) {
            if (!line.hasOption("o")) {
                return false;
            }
            String operation = line.getOptionValue("o");
            if (operation.equals("C")) {
                if (!line.hasOption("n")) {
                    return false;
                }
                if (line.hasOption("i")) {
                    return false;
                }
                if (line.hasOption("m")) {
                    try {
                        Long.parseLong(line.getOptionValue("m"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
                if (line.hasOption("g")) {
                    try {
                        Long.parseLong(line.getOptionValue("g"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
            } else if (operation.equals("R")) {
                if (!line.hasOption("i")) {
                    return false;
                } else {
                    try {
                        Long.parseLong(line.getOptionValue("i"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
            } else if (operation.equals("U")) {
                if (!line.hasOption("i")) {
                    return false;
                } else {
                    try {
                        Long.parseLong(line.getOptionValue("i"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
                if (line.hasOption("m")) {
                    try {
                        Long.parseLong(line.getOptionValue("m"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
                if (line.hasOption("g")) {
                    try {
                        Long.parseLong(line.getOptionValue("g"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
            } else if (operation.equals("D")) {
                if (!line.hasOption("i")) {
                    return false;
                } else {
                    try {
                        Long.parseLong(line.getOptionValue("i"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
            } else if (operation.equals("A")) {
                // All records query
            } else if (operation.equals("N")) {
                // Number of records query
            } else {
                // nothing like C, R, U, D, A or N
                return false;
            }
        }

        // REGION
        if (line.hasOption("r")) {
            if (!line.hasOption("o")) {
                return false;
            }
            String operation = line.getOptionValue("o");
            if (operation.equals("C")) {
                if (!line.hasOption("n")) {
                    return false;
                }
                if (line.hasOption("i")) {
                    return false;
                }
                if (line.hasOption("d")) {
                    if (line.getOptionValue("d").length() > 512) {
                        return false;
                    }
                }
                if (line.hasOption("a")) {
                    try {
                        Long.parseLong(line.getOptionValue("a"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
            } else if (operation.equals("R")) {
                if (!line.hasOption("i")) {
                    return false;
                } else {
                    try {
                        Long.parseLong(line.getOptionValue("i"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
            } else if (operation.equals("U")) {
                if (!line.hasOption("i")) {
                    return false;
                } else {
                    try {
                        Long.parseLong(line.getOptionValue("i"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
                if (!line.hasOption("n")) {
                    return false;
                }
                if (line.hasOption("d")) {
                    if (line.getOptionValue("d").length() > 512) {
                        return false;
                    }
                }
                if (line.hasOption("a")) {
                    try {
                        Long.parseLong(line.getOptionValue("a"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
            } else if (operation.equals("D")) {
                if (!line.hasOption("i")) {
                    return false;
                } else {
                    try {
                        Long.parseLong(line.getOptionValue("i"));
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                }
            } else if (operation.equals("A")) {
                // All records query
            } else if (operation.equals("N")) {
                // Number of records query
            } else {
                // nothing line C, R, U, D, A or N
                return false;
            }
        }
        return true;
    }
}

