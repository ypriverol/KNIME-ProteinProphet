package de.mpc.tools.knimeproteinprophet;

import org.knime.core.node.defaultnodesettings.DefaultNodeSettingsPane;
import org.knime.core.node.defaultnodesettings.DialogComponentBoolean;
import org.knime.core.node.defaultnodesettings.DialogComponentNumber;
import org.knime.core.node.defaultnodesettings.DialogComponentString;
import org.knime.core.node.defaultnodesettings.DialogComponentStringSelection;
import org.knime.core.node.defaultnodesettings.SettingsModelBoolean;
import org.knime.core.node.defaultnodesettings.SettingsModelDoubleBounded;
import org.knime.core.node.defaultnodesettings.SettingsModelInteger;
import org.knime.core.node.defaultnodesettings.SettingsModelString;

/**
 * <code>NodeDialog</code> for the "ProteinProphet" Node.
 * KNIME node to perform ProteinProphet inference
 *
 * This node dialog derives from {@link DefaultNodeSettingsPane} which allows
 * creation of a simple dialog with standard components. If you need a more 
 * complex dialog please derive directly from 
 * {@link org.knime.core.node.NodeDialogPane}.
 * 
 * @author julianu
 */
public class ProteinProphetNodeDialog extends DefaultNodeSettingsPane {
	/**
	 * New pane for configuring ProteinProphet node dialog.
	 * This is just a suggestion to demonstrate possible default dialog
	 * components.
	 */
	protected ProteinProphetNodeDialog() {
		super();
		
		addDialogComponent(new DialogComponentStringSelection(
				new SettingsModelString(ProteinProphetNodeModel.CFGKEY_ENZYME, ProteinProphetNodeModel.DEFAULT_ENZYME),
				"Enzyme:", ProteinProphetNodeModel.ALLOWED_ENZYMES));
		
		addDialogComponent(new DialogComponentNumber(
				new SettingsModelDoubleBounded(ProteinProphetNodeModel.CFGKEY_MINPEPPROB, ProteinProphetNodeModel.DEFAULT_MINPEPPROB, 0.0, 1.0),
				"minimal peptide probability:", 0.01));
		
		addDialogComponent(new DialogComponentBoolean(
				new SettingsModelBoolean(ProteinProphetNodeModel.CFGKEY_CORRECTPROBS, ProteinProphetNodeModel.DEFAULT_CORRECTPROBS),
				"correct probability from error probability"));
		
		addDialogComponent(new DialogComponentBoolean(
				new SettingsModelBoolean(ProteinProphetNodeModel.CFGKEY_IPROPHET, ProteinProphetNodeModel.DEFAULT_IPROPHET),
				"use iProphet"));
		
		addDialogComponent(new DialogComponentString(
				new SettingsModelString(ProteinProphetNodeModel.CFGKEY_DECOYPREFIX, ProteinProphetNodeModel.DEFAULT_DECOYPREFIX),
				"Decoy prefix:", true, 10));
		
		addDialogComponent(new DialogComponentNumber(
				new SettingsModelInteger(ProteinProphetNodeModel.CFGKEY_THREADS, ProteinProphetNodeModel.DEFAULT_THREADS),
				"Threads:", 1));
	}
}

